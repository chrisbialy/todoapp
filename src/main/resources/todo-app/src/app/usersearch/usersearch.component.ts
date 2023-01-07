import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Usersearch} from "../usersearch";
import {UsersearchService} from "../usersearch.service";




@Component({
  selector: 'app-usersearch',
  templateUrl: './usersearch.component.html',
  styleUrls: ['./usersearch.component.css']
})
export class UsersearchComponent implements OnInit {

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

  username: string = "";
  uid: number = 0;

  onSubmit(username: string) {
    return this.usersearchService.getUserByUsername(username)
      .subscribe(response => {
        this.usersearches = response;
        console.log(response);
      })
  }


  ngOnInit(): void {
  }

}
