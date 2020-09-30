import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AdminComponent} from './admin/admin.component';
import {ItemsComponent} from './items/items.component';
import {AdminOrdersComponent} from './admin-orders/admin-orders.component';
import {AdminUsersComponent} from './admin-users/admin-users.component';
import {ProfileComponent} from './profile/profile.component';
import {EditProfileComponent} from './edit-profile/edit-profile.component';
import {LoginComponent} from './login/login.component';

const routes: Routes = [ {
  path: '',
  component: HomeComponent
},
{
  path: 'items',
  component: ItemsComponent
},

{
  path: 'admin',
  component: AdminComponent
},
{
  path: 'orders',
  component: AdminOrdersComponent
},{
  path: 'users',
  component: AdminUsersComponent
},
{
  path: 'profile',
  component: ProfileComponent
},
{
  path: 'edit',
  component: EditProfileComponent
},
{
  path: 'login',
  component: LoginComponent
}];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
