import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {environment} from "../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Usersearch} from "./usersearch";

@Injectable({
  providedIn: 'root'
})
export class UsersearchService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }



  public getUserByUsername(username: string): Observable<Usersearch> {
    `${this.apiServerUrl}/user/username/${username}`;
    return this.http.get<Usersearch>(`${this.apiServerUrl}/user/username/${username}`)
  }

  public getUserById(uid: number): Observable<Usersearch> {
    `${this.apiServerUrl}/user/${uid}`;
    return this.http.get<Usersearch>(`${this.apiServerUrl}/user/${uid}`)
  }

}
