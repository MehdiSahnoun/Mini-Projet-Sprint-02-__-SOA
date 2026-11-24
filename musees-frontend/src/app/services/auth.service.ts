import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { JwtHelperService } from '@auth0/angular-jwt';
import { User } from '../models';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  apiURL: string = 'http://localhost:8082/users';
  token!: string;
  loggedUser!: string;
  isloggedIn: Boolean = false;
  roles!: string[];
  regitredUser: User = new User();
  private helper = new JwtHelperService();

  constructor(
    private router: Router,
    private http: HttpClient
  ) {}

  login(user: User) {
    return this.http.post<User>(this.apiURL + '/login', user, { observe: 'response' });
  }

  registerUser(user: User) {
    return this.http.post<User>(this.apiURL + '/register', user, { observe: 'response' });
  }

  validateEmail(code: string) {
    return this.http.get<User>(this.apiURL + '/verifyEmail/' + code);
  }

  setRegistredUser(user: User) {
    this.regitredUser = user;
  }

  getRegistredUser(): User {
    return this.regitredUser;
  }

  saveToken(jwt: string) {
    localStorage.setItem('jwt', jwt);
    this.token = jwt;
    this.isloggedIn = true;
    this.decodeJWT();
  }

  decodeJWT() {
    if (this.token == undefined)
      return;
    const decodedToken = this.helper.decodeToken(this.token);
    if (decodedToken) {
      this.roles = decodedToken.roles;
      this.loggedUser = decodedToken.sub;
    }
  }

  loadToken() {
    this.token = localStorage.getItem('jwt')!;
    if (this.token) {
      this.isloggedIn = true;
      this.decodeJWT();
    }
  }

  getToken(): string {
    return this.token;
  }

  isAdmin(): Boolean {
    if (!this.roles)
      return false;
    return this.roles.indexOf('ADMIN') >= 0;
  }

  isTokenExpired(): Boolean {
    if (!this.token)
      return true;
    return this.helper.isTokenExpired(this.token);
  }

  logout() {
    this.loggedUser = undefined!;
    this.roles = undefined!;
    this.token = undefined!;
    this.isloggedIn = false;
    localStorage.removeItem('jwt');
    this.router.navigate(['/login']);
  }

  // Compatibility helpers for existing templates and components
  isLoggedIn(): boolean {
    return !!this.isloggedIn;
  }

  currentUser(): string | null {
    return this.loggedUser || null;
  }

  signup(u: string, p: string): boolean {
    if (u && p) {
      return true;
    }
    return false;
  }
}