import { Component } from '@angular/core';
import { NotificationsService } from './shared/notifications.service';
export class Message
{
  text: string;
}

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  providers: [NotificationsService]

})
export class AppComponent {
  title = 'Webshop';
  sentMessage;
  receivedMessages: Array<Message> = [];

  constructor(private service: NotificationsService) {
    this.service.connect();

    service.getState().subscribe((msg) => {
      this.receivedMessages.unshift({text: msg});
    });
  }
 
}
