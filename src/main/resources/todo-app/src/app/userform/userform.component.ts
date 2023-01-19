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
