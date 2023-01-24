import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { UserlistComponent } from './userlist/userlist.component';
import { UserformComponent } from './userform/userform.component';
import { TodolistComponent } from './todolist/todolist.component';
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { TodolistsearchComponent } from './todolistsearch/todolistsearch.component';
import { UsersearchComponent } from './usersearch/usersearch.component';
import { UsersearchidComponent } from './usersearchid/usersearchid.component';
import { UserComponent } from './user/user.component';
import { LoginComponent } from './login/login.component';
import {HttpInterceptorService} from "./basic-auth-interceptor.service";
import { AddtodoitemComponent } from './addtodoitem/addtodoitem.component';

@NgModule({
  declarations: [
    AppComponent,
    UserlistComponent,
    UserformComponent,
    TodolistComponent,
    TodolistsearchComponent,
    UsersearchComponent,
    UsersearchidComponent,
    UserComponent,
    LoginComponent,
    AddtodoitemComponent
  ],
    imports: [
        BrowserModule,
        AppRoutingModule,
        HttpClientModule,
        FormsModule,
        ReactiveFormsModule
    ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS,
      useClass: HttpInterceptorService,
      multi: true
    }
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }

