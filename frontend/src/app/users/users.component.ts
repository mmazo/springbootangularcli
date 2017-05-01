import { Component, OnInit } from '@angular/core';
import {UsersService} from "./users.service";
import {User} from "./user";

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.scss']
})
export class UsersComponent implements OnInit {

  public users: User[] = [];

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.usersService.getList().subscribe(
      (users: User[]) => {
        this.users = users;
      }, (error: any) => {
        console.log(error);
      });
  }

}
