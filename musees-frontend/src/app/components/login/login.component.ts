import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';
import { User } from '../../models';

@Component({
  selector: 'app-login',
  standalone: false,
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent {
  user: User = new User();
  err: number = 0;
  message: string = 'login ou mot de passe erronés..';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  onLoggedin(): void {
    this.authService.login(this.user).subscribe({
      next: (data) => {
        let jwToken = data.headers.get('Authorization')!;
        this.authService.saveToken(jwToken);
        this.router.navigate(['/']);
      },
      error: (err) => {
        this.err = 1;
        if (err.error?.errorCause === 'disabled') {
          this.message = 'Utilisateur désactivé, Veuillez contacter votre Administrateur';
        }
      }
    });
  }

  // Alias for compatibility
  submit(): void {
    this.onLoggedin();
  }
}