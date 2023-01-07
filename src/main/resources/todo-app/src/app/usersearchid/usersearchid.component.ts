import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Usersearch} from "../usersearch";
import {UsersearchService} from "../usersearch.service";

@Component({
  selector: 'app-usersearchid',
  templateUrl: './usersearchid.component.html',
  styleUrls: ['./usersearchid.component.css']
})
export class UsersearchidComponent implements OnInit {

  usersearches: Usersearch = {

    uid: undefined,
    username: "",
    firstname: "",
    lastname: "",
    email: "",
    password: "",
    roles: {
      rid: undefined,
      role: ""
    }
  };

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private usersearchService: UsersearchService) { }

  uid: number = 0;

  onSubmitId(uid: number) {
    return this.usersearchService.getUserById(uid)
      .subscribe(response => {
        this.usersearches = response
        console.log(response);
      })
  }


  ngOnInit(): void {
  }

}
