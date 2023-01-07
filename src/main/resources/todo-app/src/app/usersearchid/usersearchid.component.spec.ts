import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UsersearchidComponent } from './usersearchid.component';

describe('UsersearchidComponent', () => {
  let component: UsersearchidComponent;
  let fixture: ComponentFixture<UsersearchidComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UsersearchidComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UsersearchidComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
