package com.example.tiktaktoe;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.fragment.app.DialogFragment;
import androidx.annotation.NonNull;

public class CustomDialogFragment extends DialogFragment {

    @NonNull
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        return builder
                .setTitle("Выйграли Крестики")
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setMessage("Игра окончена")
                .setPositiveButton("Начать сначала", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Переход
                        getActivity().recreate();
                        dismiss();
                    }
                })
                .setNegativeButton("Главное меню", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Переход
                        getActivity().finish();
                    }
                })
                .create();
    }


    public void Restart(){

    }

}