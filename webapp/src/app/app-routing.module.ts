import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {OAuthRedirectComponent} from "./oauth-redirect/oauth-redirect.component";
import {HomeComponent} from "./home/home.component";

const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'oauth2/redirect', component: OAuthRedirectComponent },
  { path: 'home', component: HomeComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
