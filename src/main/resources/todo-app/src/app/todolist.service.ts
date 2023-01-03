import { Injectable } from '@angular/core';
import {Todolist} from "./todolist";
import {environment} from "../environments/environment";
import {HttpClient, HttpEvent} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class TodolistService {

  private apiServerUrl = environment.apiBaseUrl;
  constructor(private http: HttpClient) { }

  public getAllItems(): Observable<Todolist[]> {
    return this.http.get<Todolist[]>(`${this.apiServerUrl}/todolist`);
  }

  // @ts-ignore
  public getItemByUsername(username: string): Observable<Todolist[]> {
    `${this.apiServerUrl}/todolist/username/${username}`;
    return this.http.get<Todolist[]>(`${this.apiServerUrl}/todolist/username/${username}`)
  }

  public save(todolist: Todolist): Observable<Todolist> {
    return this.http.post<Todolist>(`${this.apiServerUrl}/todolist/addItem`, todolist);
  }

  deleteItem(todolist: Todolist): Observable<Todolist> {
    `${this.apiServerUrl}/todolist/deleteItem/${todolist.tid}`;
    return this.http.delete<Todolist>(`${this.apiServerUrl}/todolist/deleteItem/${todolist.tid}`)
  }

}
