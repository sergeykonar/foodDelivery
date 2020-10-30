package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatDialogFragment;

public class ConfirmFoodDialog extends AppCompatDialogFragment {
    private EditText editText;
    private String food;
    private TextView foodNameDialog;
    private Context context;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity(), R.style.MyCustomTheme);
        LayoutInflater inflater = getActivity().getLayoutInflater();


        assert getArguments() != null;
        food = getArguments().getString("Dish");
        System.out.println(food);

        View view = inflater.inflate(R.layout.confirm_dialog, null);




        foodNameDialog = (TextView) view.findViewById(R.id.foodNameDialog);
        foodNameDialog.setText(food);


        builder.setView(view).setTitle("Confirmation")
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getContext(), "OK", Toast.LENGTH_LONG).show();
                    }
                });

        editText = view.findViewById(R.id.editTextNumber);
        AlertDialog dialog = builder.create();
        dialog.getWindow().getAttributes().windowAnimations = R.anim.slide_in_left;
        return builder.create();
    }
}
