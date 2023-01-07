import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TodolistService} from "../todolist.service";
import {Todolist} from "../todolist";

@Component({
  selector: 'app-todolistsearch',
  templateUrl: './todolistsearch.component.html',
  styleUrls: ['./todolistsearch.component.css']
})
export class TodolistsearchComponent implements OnInit {

  todolistsearches?: Todolist[] = [];


  constructor(
    private route: ActivatedRoute,
    private router: Router,

    private todolistService: TodolistService) { }
     username: string = "";

  onSubmit(username: string) {
    this.todolistService.getItemByUsername(username)
      .subscribe(response => {
        this.todolistsearches = response;
      })
  }


  ngOnInit(): void {
  }

}
