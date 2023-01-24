import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../user.service";
import {User} from "../user";

@Component({
  selector: 'app-userform',
  templateUrl: './userform.component.html',
  styleUrls: ['./userform.component.css']
})
export class UserformComponent implements OnInit {
  public user: User = {
    username: "",
    firstname: "",
    lastname: "",
    email: "",
    password: "",
    role: "user"
  }
  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService) {
  }

  /* Save user allows to write a new user with a user role only. [which initially makes sense for anyone signing up]
    An additional feature should be implemented in Admin dashboard, so the admin
   role could be assigned to any user by existing admin.
   Also, it would be worth assigning both an admin a user & an admin role, so it could be used for access permissions [hasRole]*/

  onSubmit() {
    this.userService.save(this.user)
      .subscribe(result => this.gotoUserList());
  }

  gotoUserList() {
    this.router.navigate(['/userlist']);
  }

  ngOnInit(): void {
  }

}
