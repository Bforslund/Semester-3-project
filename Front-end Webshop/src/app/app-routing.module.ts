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
import {OrderHistoryComponent} from './order-history/order-history.component';
import {RegisterComponent} from './register/register.component'
import { state } from '@angular/animations';
import { AuthGuard } from  './auth/auth.guard';
import { AdminAuthGuard } from  './auth/admin-auth.guard';
import { ProductDetailsComponent } from './product-details/product-details.component';
const routes: Routes = [ {
  path: 'home',
  component: HomeComponent
},
{
  path: 'products',
  component: ItemsComponent
},
{
  path: 'products/:id',
  component: ProductDetailsComponent
},
{
  path: 'admin',
  component: AdminComponent,
  canActivate: [ AdminAuthGuard ]
},
{
  path: 'orders',
  component: AdminOrdersComponent,
  canActivate: [ AdminAuthGuard ]
},{
  path: 'users',
  component: AdminUsersComponent,
  canActivate: [ AdminAuthGuard ]
},
{
  path: 'profile',
  component: EditProfileComponent,
  canActivate: [ AuthGuard ]
},
{
  path: 'login',
  component: LoginComponent
},
{
  path: 'receipt/:id',
  component: ReceiptComponent,
  canActivate: [ AuthGuard ]
},
{
  path: 'checkout',
  component: CheckOutComponent
},
{
  path: 'statistics',
  component: StatisticsComponent,
  canActivate: [ AdminAuthGuard ]
},
{
  path: 'orderhistory',
  component: OrderHistoryComponent,
  canActivate: [ AuthGuard ]
},
{
  path: 'register',
  component: RegisterComponent
},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
