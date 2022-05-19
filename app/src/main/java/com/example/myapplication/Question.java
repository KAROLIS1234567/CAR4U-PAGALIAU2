package com.example.myapplication;

public class Question {
    public String questions[] = {
            "Transporto priemonė skirta",
            "Automobilio dydis",
            "Varomieji ratai",
            "Prioritetas",
            "Privalumas"

    };

    public String choices[][] = {
            {"Kasdieniniam naudojimui", "Nusigauti iki tam tikro taško(pvz: darbo)", "Kelionėms", "Retiems važiavimams"},
            {"Didelis(Džipas, Pikapas)", "Vidutinis(Sedanas)", "Mažas(Hečbekas)", "Labai mažas"},
            {"Priekiniai", "Galiniai", "Visi keturi", "Nėra skirtumo"},
            {"Patogus salonas", "Graži išvaizda", "Greitis, galia", "Mažas kuro sunaudojimas"},
            {"Varoma elektra arba hibridas", "Šildomos sėdynės", "Septynios ar daugiau sėdimų vietų", "-"}
    };

    public String getQuestion(int a){
        String question = questions[a];
        return question;
    }

    public String getchoice1(int a){
        String choice = choices[a][0];
        return choice;
    }

    public String getchoice2(int a){
        String choice = choices[a][1];
        return choice;
    }

    public String getchoice3(int a){
        String choice = choices[a][2];
        return choice;
    }

    public String getchoice4(int a){
        String choice = choices[a][3];
        return choice;
    }


}