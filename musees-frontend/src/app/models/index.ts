export interface Musee {
  idMusee: number;
  nomMusee: string;
  superficieMusee: number;
  dateInauguration: Date;
}

export interface Oeuvre {
  idOeuvre: number;
  titreOeuvre: string;
  anneeCreation: number;
  dateAcquisition: Date;
  musee: Musee;
}

export class User {
  id?: number;
  username!: string;
  email!: string;
  password!: string;
  enabled?: boolean;
  roles?: string[];
  role?: string;
}