import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {TokenService} from "../service/token.service";

@Component({
  selector: 'app-oauth-redirect',
  templateUrl: './oauth-redirect.component.html',
  styleUrls: ['./oauth-redirect.component.scss']
})
export class OAuthRedirectComponent implements OnInit {

  constructor(private route: ActivatedRoute, private tokenService: TokenService, private router: Router) { }

  ngOnInit() {
    this.route.queryParams.subscribe(params => {
      let token = params["token"];
      this.tokenService.set(token);
      this.router.navigate(['home']);
    });
  }

}
