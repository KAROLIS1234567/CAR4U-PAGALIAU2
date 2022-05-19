package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Random;


public class Fragment3 extends Fragment implements View.OnClickListener {

    Button btn_one, btn_two, btn_three, btn_four;
    TextView tv_question;

    private Question question = new Question();

    private String answer;
    private int questionLength = question.questions.length;

    Random random;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        random = new Random();


        btn_one = (Button) view.findViewById(R.id.btn_one);
        btn_one.setOnClickListener(this);
        btn_two = (Button) view.findViewById(R.id.btn_two);
        btn_two.setOnClickListener(this);
        btn_three = (Button) view.findViewById(R.id.btn_three);
        btn_three.setOnClickListener(this);
        btn_four = (Button) view.findViewById(R.id.btn_four);
        btn_four.setOnClickListener(this);

        tv_question = (TextView) view.findViewById(R.id.tv_question);

        NextQuestion(random.nextInt(questionLength));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_one:
                Toast.makeText(getActivity().getApplicationContext(), "Puiku", Toast.LENGTH_SHORT).show();
                NextQuestion(random.nextInt(questionLength));

                break;

            case R.id.btn_two:
                Toast.makeText(getActivity().getApplicationContext(), "Puiku", Toast.LENGTH_SHORT).show();
                NextQuestion(random.nextInt(questionLength));


                break;

            case R.id.btn_three:
                Toast.makeText(getActivity().getApplicationContext(), "Puiku", Toast.LENGTH_SHORT).show();
                NextQuestion(random.nextInt(questionLength));


                break;

            case R.id.btn_four:
                Toast.makeText(getActivity().getApplicationContext(), "Puiku", Toast.LENGTH_SHORT).show();
                NextQuestion(random.nextInt(questionLength));


                break;
        }
    }

    private void NextQuestion(int num) {
        tv_question.setText(question.getQuestion(num));
        btn_one.setText(question.getchoice1(num));
        btn_two.setText(question.getchoice2(num));
        btn_three.setText(question.getchoice3(num));
        btn_four.setText(question.getchoice4(num));

    }
}