import { Component, OnInit } from '@angular/core';
import {HttpService} from "../service/http.service";
import {Observable} from "rxjs";
import {User} from "../model/user.model";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit {

  user: Observable<User>;

  constructor(private http: HttpService) { }

  ngOnInit() {
    this.user = this.http.doGetRequest("user/me");
    //this.user.subscribe(u => {console.log(u);});
  }

}
