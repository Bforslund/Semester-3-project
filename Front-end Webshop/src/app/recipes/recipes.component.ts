import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
import { Component, OnInit } from '@angular/core';
import * as jsPDF from 'jspdf';
import html2canvas from 'html2canvas';
import { RecipesService } from '../shared/recipes.service';
import { UsersService } from '../shared/users.service';
import { User } from '../model/User';
import { NotificationsService } from '../shared/notifications.service';

export class Recipe {
  constructor(
    public id: number,
    public content: string,
    public instructions : string,
 public title : string,
    public date: string,
   public userId: number,
   
) {  }
}

@Component({
  selector: 'app-recipes',
  templateUrl: './recipes.component.html',
  styleUrls: ['./recipes.component.scss']
})
export class RecipesComponent implements OnInit {
 newRecipe = new Recipe(1, "idk","100 g rumsvarmt","Tigermuffins, 10 st.","234",1);
 allRecipes:Recipe[];
 user:User;
  constructor(private service: RecipesService,private Uservice: UsersService,private Notservice: NotificationsService) {}
  data = {};
  id:string;

  content : string;
  instructions : string;
  title : string;
  ngOnInit(): void {
    this.id = localStorage.getItem('userId');
    if(this.id){
      this.Uservice.getUserById(this.id)
      .subscribe((data)=>{
        console.log(data);
       this.user = <User>data;
      });
    }else{
      this.user = new User(999, "","","",1,"","","","");
    }
   
    this.service.getRecipes()
    .subscribe((data)=>{
      console.log(data);
      this.allRecipes = <Recipe[]>data;
  });
  }

  createRecipe() {
    this.sendMessage();
    var today = new Date().toISOString().slice(0, 10);
  
      this.newRecipe.content = this.content;
      this.newRecipe.instructions = this.instructions;
      this.newRecipe.title = this.title;
      this.newRecipe.userId = this.user.id;
      this.newRecipe.date = today;
    
    this.service.postRecipes(this.newRecipe).subscribe(
      (res: any) => {
      console.log("Submitted");
      });
      
   window.location.reload()
  }

  sendMessage(): void {
    this.Notservice.sendMessage("New recipe added!");
  }

  // disconnect(): void {
  //   this.Notservice.close();
  // }

  // connect(): void {
  //   this.Notservice.connect();
  // }


  export(){
    var data = document.getElementById('pdfTable');
      html2canvas(data).then(canvas => {  
        // Few necessary setting options  
        var imgWidth = 208;   
        var pageHeight = 295;    
        var imgHeight = canvas.height * imgWidth / canvas.width;  
        var heightLeft = imgHeight;  
    
        const contentDataURL = canvas.toDataURL('image/png')  
        let pdf = new jsPDF('p', 'mm', 'a4'); // A4 size page of PDF  
        var position = 0;  
        pdf.addImage(contentDataURL, 'PNG', 0, position, imgWidth, imgHeight)  
        pdf.save('MYPdf.pdf'); // Generated PDF   
      });  

  }

}
