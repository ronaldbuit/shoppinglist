import {Injectable} from "@angular/core";

@Injectable({
  providedIn: "root"
  })
export class TokenService {

  private TOKEN_KEY:string = "shoppinglist-token";

  public set(token: string): void {
    sessionStorage.setItem(this.TOKEN_KEY, token);
  }

  public get(): string {
    return sessionStorage.getItem(this.TOKEN_KEY);
  }
}
