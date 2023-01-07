import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserlistComponent } from './userlist/userlist.component';
import { UserformComponent } from './userform/userform.component';
import { TodolistComponent } from './todolist/todolist.component';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { TodolistsearchComponent } from './todolistsearch/todolistsearch.component';
import { UsersearchComponent } from './usersearch/usersearch.component';
import { UsersearchidComponent } from './usersearchid/usersearchid.component';
import { UserComponent } from './user/user.component';

@NgModule({
  declarations: [
    AppComponent,
    UserlistComponent,
    UserformComponent,
    TodolistComponent,
    TodolistsearchComponent,
    UsersearchComponent,
    UsersearchidComponent,
    UserComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
