import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserlistComponent} from "./userlist/userlist.component";
import {UserformComponent} from "./userform/userform.component";
import {TodolistComponent} from "./todolist/todolist.component";
import {TodolistsearchComponent} from "./todolistsearch/todolistsearch.component";
const routes: Routes = [
  { path: 'user', component: UserlistComponent },
  {path: 'signUp', component: UserformComponent},
  {path: 'todolist', component: TodolistComponent},
  {path: 'todolistsearch', component: TodolistsearchComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
