import { Injectable } from '@angular/core';
import {User} from "./user";
import {environment} from "../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiServerUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) {}
  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(`${this.apiServerUrl}/user`);
  }



  public save(user: User) {
    return this.http.post<User>(`${this.apiServerUrl}/user/addUser`, user);
  }

  deleteUser(user: User): Observable<User> {
    `${this.apiServerUrl}/user/deleteuser/${user.uid}`;
    return this.http.delete<User>(`${this.apiServerUrl}/user/deleteuser/${user.uid}`)
  }

}
