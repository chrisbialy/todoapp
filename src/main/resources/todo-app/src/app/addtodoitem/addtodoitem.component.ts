import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TodolistService} from "../todolist.service";
import {Todolist} from "../todolist";

@Component({
  selector: 'app-addtodoitem',
  templateUrl: './addtodoitem.component.html',
  styleUrls: ['./addtodoitem.component.css']
})
export class AddtodoitemComponent implements OnInit {


 public todolist: Todolist = {
    item: "",
    username: ""
  }

  constructor(
  private route: ActivatedRoute,
  private router: Router,
  private todolistService: TodolistService)
  { }


    /* Initially adding items to ToDoList did not work as expected as it did not take userID [uid]
       into account when writing data to the DB.
       The uid in todolist table was getting NULL value what resulted in not displaying a todolist per user - front end
       However, apparently it started to working */

  onSubmit() {
    this.todolistService.save(this.todolist)
    .subscribe(result => this.gotoToDoList());
  }

  gotoToDoList() {
      this.router.navigate(['/todolist']);
    }

  ngOnInit(): void {
  }

}
