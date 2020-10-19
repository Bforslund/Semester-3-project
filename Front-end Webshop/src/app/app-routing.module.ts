import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {HomeComponent} from './home/home.component';
import {AdminComponent} from './admin/admin.component';
import {ItemsComponent} from './items/items.component';
import {AdminOrdersComponent} from './admin-orders/admin-orders.component';
import {AdminUsersComponent} from './admin-users/admin-users.component';
import {EditProfileComponent} from './edit-profile/edit-profile.component';
import {LoginComponent} from './login/login.component';
import {ReceiptComponent} from './receipt/receipt.component';
import {CheckOutComponent} from './check-out/check-out.component';
import {StatisticsComponent} from './statistics/statistics.component';
import { state } from '@angular/animations';

const routes: Routes = [ {
  path: 'home',
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
  component: EditProfileComponent
},
{
  path: 'login',
  component: LoginComponent
},
{
  path: 'receipt/:id',
  component: ReceiptComponent
},
{
  path: 'checkout',
  component: CheckOutComponent
},
{
  path: 'statistics',
  component: StatisticsComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
