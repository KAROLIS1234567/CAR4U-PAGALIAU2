package com.example.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.myapplication.model.Answer;
import com.example.myapplication.model.Car;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Fragment2 extends Fragment {

    private RadioGroup.OnCheckedChangeListener onCheckedChangeListener = (group, checkedId) -> {
        switch (checkedId) {
            case R.id.vyras:
                // Write your code here
                break;
            case R.id.moteris:
                // Write your code here
                break;
            case R.id.kita:
                // Write your code here
                break;
            default:
                break;
        }
    };


    public Fragment2() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

//        EditText amzius = (EditText) view.findViewById(R.id.amzius);
//        String Amzius = amzius.getText().toString();
//
//        EditText turimasuma = (EditText) view.findViewById(R.id.turimasuma);
//        String Turimasuma = turimasuma.getText().toString();


        RadioGroup radioGroup = view.findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(onCheckedChangeListener);

        Button btnSubmit = view.findViewById(R.id.button2);
        btnSubmit.setOnClickListener(view1 -> {
            Navigation.findNavController(view).navigate(R.id.action_fragment2_to_nav_fragment3);
        });

        String[] budget = getResources().getStringArray(R.array.budget);
        ArrayAdapter budgetArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, budget);
        AutoCompleteTextView budgetAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewBudget);
        budgetAutocompleteTV.setAdapter(budgetArrayAdapter);

        String[] age = getResources().getStringArray(R.array.age);
        ArrayAdapter ageArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, age);
        AutoCompleteTextView ageAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewAge);
        ageAutocompleteTV.setAdapter(ageArrayAdapter);


        String[] usedForDriving = getResources().getStringArray(R.array.user_for_driving);
        ArrayAdapter usedForDrivingArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, usedForDriving);
        AutoCompleteTextView usedForDrivingAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewUsedForDriving);
        usedForDrivingAutocompleteTV.setAdapter(usedForDrivingArrayAdapter);

        String[] carSize = getResources().getStringArray(R.array.car_size);
        ArrayAdapter carSizeArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, carSize);
        AutoCompleteTextView carSizeAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewCarSize);
        carSizeAutocompleteTV.setAdapter(carSizeArrayAdapter);


        String[] driveWheels = getResources().getStringArray(R.array.drive_wheels);
        ArrayAdapter driveWheelsArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, driveWheels);
        AutoCompleteTextView driveWheelsAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewDriveWheels);
        driveWheelsAutocompleteTV.setAdapter(driveWheelsArrayAdapter);

        String[] questionPriority = getResources().getStringArray(R.array.question_priority);
        ArrayAdapter questionPriorityArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, questionPriority);
        AutoCompleteTextView questionPriorityAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewQuestionPriority);
        questionPriorityAutocompleteTV.setAdapter(questionPriorityArrayAdapter);

        String[] questionAdvantage = getResources().getStringArray(R.array.question_advantage);
        ArrayAdapter questionAdvantageArrayAdapter = new ArrayAdapter(getContext(), R.layout.dropdown_menu, questionAdvantage);
        AutoCompleteTextView questionAdvantageAutocompleteTV = view.findViewById(R.id.autoCompleteTextViewQuestionAdvantage);
        questionAdvantageAutocompleteTV.setAdapter(questionAdvantageArrayAdapter);


        TextView carName = view.findViewById(R.id.carName);
        ImageView carImage = view.findViewById(R.id.carImage);


        List<Car> carsList = getCarDataSource();

        Button btnGetResult = view.findViewById(R.id.btnGetResult);
        btnGetResult.setOnClickListener(view12 -> {
            String budgetSelected = budgetAutocompleteTV.getText().toString();
            String ageSelected = ageAutocompleteTV.getText().toString();
            String usedForDrivingSelected = usedForDrivingAutocompleteTV.getText().toString();
            String carSizeSelected = carSizeAutocompleteTV.getText().toString();
            String driveWheelsSelected = driveWheelsAutocompleteTV.getText().toString();
            String questionPrioritySelected = questionPriorityAutocompleteTV.getText().toString();
            String questionAdvantageSelected = questionAdvantageAutocompleteTV.getText().toString();

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {

                List<Car> car = carsList.stream()
                        .filter(q -> q.getAnswer().getBudget().equals(budgetSelected)
                                &&  Arrays.stream(q.getAnswer().getAge()).anyMatch(e-> e.equals(ageSelected))
                        && q.getAnswer().getUsedForDriving().equals(usedForDrivingSelected)
                        && q.getAnswer().getSize().equals(carSizeSelected)
                        && q.getAnswer().getDriverWheels().equals(driveWheelsSelected)
                        && q.getAnswer().getQuestionPriority().equals(questionPrioritySelected)
                        && q.getAnswer().getQuestionAdvantage().equals(questionAdvantageSelected))
                        .collect(Collectors.toList());

                if (car.size() > 0){
                    Car c = car.get(0);
                    carName.setText(c.getName());
                    carImage.setImageResource(c.getImage());
                }else {
                    Toast.makeText(getContext().getApplicationContext(), "no result found", Toast.LENGTH_SHORT).show();
                }

            }

        });




    }

    private  List<Car> getCarDataSource() {
        List<Car> carsList = new ArrayList<>();
        carsList.add(new Car(
                "Toyota corolla", R.drawable.img_car_1,
                new Answer(
                        "0-2000",
                        new String[]{"18-25", "26-45"},
                        "everyday ride, /work",
                        "big(jeep)",
                        "all four",
                        "comfortable salon",
                        "hibridas-electrical car")));
        carsList.add(new Car("Car", R.drawable.img_car_2,
                new Answer(
                        "5100-15000",
                        new String[]{"18-25", "26-45"},
                        "for vacations",
                        "medium(coupe)",
                        "all four",
                        "beautiful design",
                        "heatable seats")));

        return carsList;
    }


}