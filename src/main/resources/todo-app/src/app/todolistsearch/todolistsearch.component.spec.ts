import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodolistsearchComponent } from './todolistsearch.component';

describe('TodolistsearchComponent', () => {
  let component: TodolistsearchComponent;
  let fixture: ComponentFixture<TodolistsearchComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodolistsearchComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodolistsearchComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
