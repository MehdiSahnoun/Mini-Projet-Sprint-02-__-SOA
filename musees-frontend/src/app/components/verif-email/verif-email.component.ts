import { Component, OnInit } from '@angular/core';
import { User } from '../../models';
import { Router } from '@angular/router';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-verif-email',
  standalone: true,
  imports: [],
  templateUrl: './verif-email.component.html',
  styleUrl: './verif-email.component.scss'
})
export class VerifEmailComponent implements OnInit {
  code: string = '';
  user: User = new User();
  err = '';

  constructor(
    private authService: AuthService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.user = this.authService.getRegistredUser();
  }

  onValidateEmail(): void {
    this.authService.validateEmail(this.code).subscribe({
      next: (res) => {
        alert('Email confirmé avec succès');
        this.err = '';
        this.authService.login(this.user).subscribe({
          next: (data: any) => {
            let jwToken = data.headers.get('Authorization')!;
            this.authService.saveToken(jwToken);
            this.router.navigate(['/']);
          },
          error: (err: any) => {
            console.log(err);
          }
        });
      },
      error: (err: any) => {
        if (err.status === 400) {
          if (err.error?.errorCode === 'INVALID_TOKEN') {
            this.err = 'Code invalide!';
          } else if (err.error?.errorCode === 'EXPIRED_TOKEN') {
            this.err = 'Code a expiré!';
          } else {
            this.err = err.error?.message || 'Erreur de validation';
          }
        }
        console.log(err.errorCode);
      }
    });
  }
}