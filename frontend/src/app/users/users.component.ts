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

  public selectedUser: User = new User();

  constructor(private usersService: UsersService) { }

  ngOnInit() {
    this.getAllUsers();
  }

  public select(user: User) {
    this.selectedUser = user;
  }

  public getAllUsers() {
    this.usersService.getList().subscribe(
      (users: User[]) => {
        this.users = users;
      }, (error: any) => {
        console.log(error);
      });
  }

  public addNewUser() {
    this.selectedUser = new User();
  }

  public saveUser() {
    if (this.selectedUser.id) {
      this.usersService.updateOne(this.selectedUser).subscribe(
        (user: User) => {
          this.selectedUser = user;
          this.getAllUsers();
        }, (error: any) => {
          console.log(error);
        });
    } else {
      this.usersService.createOne(this.selectedUser).subscribe(
        (user: User) => {
          this.selectedUser = user;
          this.getAllUsers();
        }, (error: any) => {
          console.log(error);
        });
    }
  }

  public deleteUser() {
    this.usersService.deleteOne(this.selectedUser.id).subscribe(
      (resp: any) => {
        console.log('delete callback');
        this.getAllUsers();
      }, (error: any) => {
        console.log(error);
      });
  }

}
