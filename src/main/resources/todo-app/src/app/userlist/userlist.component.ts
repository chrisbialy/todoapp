import { Component, OnInit } from '@angular/core';
import {UserService} from "../user.service";
import {Router} from "@angular/router";
import {User} from "../user";
import {Subscription} from "rxjs";

@Component({
  selector: 'app-userlist',
  templateUrl: './userlist.component.html',
  styleUrls: ['./userlist.component.css']
})
export class UserlistComponent implements OnInit {

  users?: User[] = [];
  private usersSubscription?: Subscription;

  public User: User = {
    username: "",
    firstname: "",
    lastname: "",
    email: "",
    password: "",
    role: ""
  }
  constructor(
    private userService: UserService,
    private router: Router) {}

ngOnInit() {
  this.userService.getAllUsers().subscribe(
    response => {
      this.users = response;
    })
}

public OnDelete(uid: User): void {
    this.userService
      .deleteUser(uid)
      .subscribe(result => this.users = this.users!!
        .filter((user) => user.uid !== uid.uid));
      console.log(uid);
}

}
