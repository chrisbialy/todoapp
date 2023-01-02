import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {UserlistComponent} from "./userlist/userlist.component";
import {UserformComponent} from "./userform/userform.component";

const routes: Routes = [
  { path: 'user', component: UserlistComponent },
  {path: 'signUp', component: UserformComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
