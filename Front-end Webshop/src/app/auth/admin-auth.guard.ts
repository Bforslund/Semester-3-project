import { Injectable } from '@angular/core';
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree, Router } from '@angular/router';
import { Observable } from 'rxjs';
import { User } from '../model/User';
import { UsersService } from '../shared/users.service';

@Injectable({
  providedIn: 'root'
})
export class AdminAuthGuard implements CanActivate {
  id:string;
  user = new User(1, "", "", "", 0, "", "", "","USER");
  constructor(private service: UsersService,private router: Router) { }
  canActivate(
    route: ActivatedRouteSnapshot,
    state: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
      
      this.service.getUser()
      .subscribe((data)=>{
       this.user = <User>data;
      
      });
      if(this.readLocalStorageValue() != null){
        if(this.user.role === "ADMIN"){
          return true;
          
        }else{
          this.router.navigate(['/home']);
         return false;
        }
      }else{
        this.router.navigate(['/login']);
        return false;
      }  
  }
  readLocalStorageValue() {
    return localStorage.getItem('userToken');
}
  
}
