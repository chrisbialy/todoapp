import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserlistComponent} from "./userlist/userlist.component";
import {UserformComponent} from "./userform/userform.component";
import {TodolistComponent} from "./todolist/todolist.component";
import {TodolistsearchComponent} from "./todolistsearch/todolistsearch.component";
import {UsersearchComponent} from "./usersearch/usersearch.component";
import {UsersearchidComponent} from "./usersearchid/usersearchid.component";
import {UserComponent} from "./user/user.component";


const routes: Routes = [
  { path: 'userlist', component: UserlistComponent },
  {path: 'user', component: UserComponent },
  {path: 'signUp', component: UserformComponent},
  {path: 'todolist', component: TodolistComponent},
  {path: 'todolistsearch', component: TodolistsearchComponent},
  {path: 'usersearch', component: UsersearchComponent},
  {path: 'usersearchid', component: UsersearchidComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
