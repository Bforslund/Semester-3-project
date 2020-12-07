import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { catchError, tap, switchAll } from 'rxjs/operators';
import {EMPTY, Observable, Subject} from 'rxjs';
import {MatSnackBar} from '@angular/material/snack-bar';
import {BehaviorSubject} from 'rxjs';

const WS_ENDPOINT = 'ws://localhost:9090/ws/notifications';

@Injectable({
  providedIn: 'root'
})
export class NotificationsService {

  constructor(private _snackBar: MatSnackBar) { }
  private socket$: WebSocketSubject<any>;
  private state$ = new BehaviorSubject<any>('');

  private static getNewWebSocket(): WebSocketSubject<any> {
    return webSocket(WS_ENDPOINT);
  }
  public connect(): void {
    if (!this.socket$ || this.socket$.closed) {
      this.socket$ = NotificationsService.getNewWebSocket() as WebSocketSubject<any>;
      this.socket$.subscribe(
        msg => this.populateMessage(msg),
        // Called whenever there is a message from the server
        err => {
          console.log('getting error');
          console.log(err);
        },
        // Called if WebSocket API signals some kind of error
        () => {
          console.log('complete');
          this.socket$ = null;
        }
        // Called when connection is closed (for whatever reason)
      );
    }
  }

  private populateMessage(message: any): void{
    if (!this.socket$){
      return;
    }
    console.log('message received: ' + message);
    this.openSnackBar();
    this.state$.next(message);
  }

  public getState(): Observable<string>{
    return this.state$.asObservable();
  }

  public sendMessage(msg: any): void {
    if (!this.socket$){
      return;
    }
    console.log('message: ' + msg);
    this.socket$.next(msg);
  }

  public close(): void {
    this.socket$.complete();
  }
  openSnackBar() {
    this._snackBar.open("New recipe added!", "Close", {
      duration: 100000,
    });
  }



}
