import { Component, OnInit } from '@angular/core';
import {Subscription} from "rxjs";
import {Router} from "@angular/router";
import {TodolistService} from "../todolist.service";
import {Todolist} from "../todolist";

@Component({
  selector: 'app-todolist',
  templateUrl: './todolist.component.html',
  styleUrls: ['./todolist.component.css']
})
export class TodolistComponent implements OnInit {

  todolists?: Todolist[] = [];

  private todolistsSubscription?: Subscription;

  public todolist: Todolist = {
    item: "",
    username: ""
  }

  constructor(
    private todolistService: TodolistService,
    private router: Router) { }

  ngOnInit() {
    this.todolistService.getAllItems().subscribe(
      response => {
        this.todolists = response;
      })
  }

  public OnDelete(tid: Todolist): void {
    this.todolistService
      .deleteItem(tid)
      .subscribe(result => this.todolists = this.todolists!!
        .filter((todolist) => todolist.tid !== tid.tid));
          console.log(tid);
  }

}
