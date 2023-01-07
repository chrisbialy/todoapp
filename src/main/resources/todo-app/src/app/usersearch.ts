export interface Usersearch {
  uid?: number
  "username": string;
  "firstname": string;
  "lastname": string;
  "email": string;
  "password": string;
  roles: {
    rid?: number;
    "role": string;
  }

}
