package com.dev.bollha.tcc_prototipo;


import android.support.test.espresso.ViewInteraction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.*;
import static android.support.test.espresso.assertion.ViewAssertions.*;
import static android.support.test.espresso.matcher.ViewMatchers.*;

import com.dev.bollha.tcc_prototipo.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest_TodosOsCadastros {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_TodosOsCadastros() {
        ViewInteraction floatingActionButton = onView(
allOf(withId(R.id.fabControlOcorrencia), isDisplayed()));
        floatingActionButton.perform(click());
        
        ViewInteraction floatingActionButton2 = onView(
allOf(withId(R.id.fabAtor), isDisplayed()));
        floatingActionButton2.perform(click());
        
        ViewInteraction floatingActionButton3 = onView(
allOf(withId(R.id.fabNew), isDisplayed()));
        floatingActionButton3.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText.perform(click());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText2.perform(replaceText("Maxwell Cravo"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText3.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText4.perform(replaceText("12345678922"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.edtIdade), isDisplayed()));
        appCompatEditText5.perform(replaceText("27"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction floatingActionButton4 = onView(
allOf(withId(R.id.fabSave), isDisplayed()));
        floatingActionButton4.perform(click());
        
        ViewInteraction floatingActionButton5 = onView(
allOf(withId(R.id.fabNew), isDisplayed()));
        floatingActionButton5.perform(click());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText6.perform(click());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText7.perform(replaceText("Iago Gabriel"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText8.perform(click());
        
        ViewInteraction appCompatEditText9 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText9.perform(replaceText("12375698715"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatEditText10 = onView(
allOf(withId(R.id.edtIdade), isDisplayed()));
        appCompatEditText10.perform(replaceText("34"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction floatingActionButton6 = onView(
allOf(withId(R.id.fabSave), isDisplayed()));
        floatingActionButton6.perform(click());
        
        ViewInteraction floatingActionButton7 = onView(
allOf(withId(R.id.fabNew), isDisplayed()));
        floatingActionButton7.perform(click());
        
        ViewInteraction appCompatEditText11 = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText11.perform(click());
        
        ViewInteraction appCompatEditText12 = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText12.perform(replaceText("Jefferson Escocard"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText13 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText13.perform(replaceText("4561239872"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatEditText14 = onView(
allOf(withId(R.id.edtIdade), isDisplayed()));
        appCompatEditText14.perform(replaceText("19"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatSpinner = onView(
allOf(withId(R.id.spnGravidade), isDisplayed()));
        appCompatSpinner.perform(click());
        
        ViewInteraction appCompatCheckedTextView = onView(
allOf(withId(android.R.id.text1), withText("Fatal"), isDisplayed()));
        appCompatCheckedTextView.perform(click());
        
        ViewInteraction floatingActionButton8 = onView(
allOf(withId(R.id.fabSave), isDisplayed()));
        floatingActionButton8.perform(click());
        
        ViewInteraction floatingActionButton9 = onView(
allOf(withId(R.id.fabBack), isDisplayed()));
        floatingActionButton9.perform(click());
        
        ViewInteraction floatingActionButton10 = onView(
allOf(withId(R.id.fabObject), isDisplayed()));
        floatingActionButton10.perform(click());
        
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.btnNovoObjeto), withText("Novo"), isDisplayed()));
        appCompatButton.perform(click());
        
        ViewInteraction appCompatEditText15 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText15.perform(click());
        
        ViewInteraction appCompatEditText16 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText16.perform(click());
        
        ViewInteraction appCompatEditText17 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText17.perform(replaceText("Teste01"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText18 = onView(
allOf(withId(R.id.edtModelo), isDisplayed()));
        appCompatEditText18.perform(click());
        
        ViewInteraction appCompatEditText19 = onView(
allOf(withId(R.id.edtModelo), isDisplayed()));
        appCompatEditText19.perform(replaceText("teste01"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText20 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText20.perform(click());
        
        ViewInteraction appCompatEditText21 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText21.perform(replaceText("01"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText22 = onView(
allOf(withId(R.id.edtAno), isDisplayed()));
        appCompatEditText22.perform(click());
        
        ViewInteraction appCompatEditText23 = onView(
allOf(withId(R.id.edtAno), isDisplayed()));
        appCompatEditText23.perform(replaceText("01"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText24 = onView(
allOf(withId(R.id.edtRenavam), isDisplayed()));
        appCompatEditText24.perform(replaceText("01"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.btnSalvarObjetoOcorrencia), withText("Salvar"), isDisplayed()));
        appCompatButton2.perform(click());
        
        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.btnNovoObjeto), withText("Novo"), isDisplayed()));
        appCompatButton3.perform(click());
        
        ViewInteraction appCompatSpinner2 = onView(
allOf(withId(R.id.spnCondutor), isDisplayed()));
        appCompatSpinner2.perform(click());
        
        ViewInteraction appCompatCheckedTextView2 = onView(
allOf(withId(android.R.id.text1), withText("Jefferson Escocard"), isDisplayed()));
        appCompatCheckedTextView2.perform(click());
        
        ViewInteraction appCompatEditText25 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText25.perform(replaceText("test02"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText26 = onView(
allOf(withId(R.id.edtModelo), isDisplayed()));
        appCompatEditText26.perform(replaceText("teste02"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText27 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText27.perform(click());
        
        ViewInteraction appCompatEditText28 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText28.perform(replaceText("02"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText29 = onView(
allOf(withId(R.id.edtAno), isDisplayed()));
        appCompatEditText29.perform(replaceText("02"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText30 = onView(
allOf(withId(R.id.edtRenavam), isDisplayed()));
        appCompatEditText30.perform(replaceText("02"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatButton4 = onView(
allOf(withId(R.id.btnSalvarObjetoOcorrencia), withText("Salvar"), isDisplayed()));
        appCompatButton4.perform(click());
        
        ViewInteraction appCompatButton5 = onView(
allOf(withId(R.id.btnNovoObjeto), withText("Novo"), isDisplayed()));
        appCompatButton5.perform(click());
        
        ViewInteraction appCompatSpinner3 = onView(
allOf(withId(R.id.spnCondutor), isDisplayed()));
        appCompatSpinner3.perform(click());
        
        ViewInteraction appCompatCheckedTextView3 = onView(
allOf(withId(android.R.id.text1), withText("Jefferson Escocard"), isDisplayed()));
        appCompatCheckedTextView3.perform(click());
        
        ViewInteraction appCompatEditText31 = onView(
allOf(withId(R.id.edtModelo), isDisplayed()));
        appCompatEditText31.perform(replaceText("teste03"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText32 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText32.perform(click());
        
        ViewInteraction appCompatEditText33 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText33.perform(replaceText("teste 03"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText34 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText34.perform(replaceText("03"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText35 = onView(
allOf(withId(R.id.edtAno), isDisplayed()));
        appCompatEditText35.perform(replaceText("03"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText36 = onView(
allOf(withId(R.id.edtRenavam), isDisplayed()));
        appCompatEditText36.perform(replaceText("0"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText37 = onView(
allOf(withId(R.id.edtRenavam), withText("0"), isDisplayed()));
        appCompatEditText37.perform(click());
        
        ViewInteraction appCompatEditText38 = onView(
allOf(withId(R.id.edtRenavam), withText("0"), isDisplayed()));
        appCompatEditText38.perform(replaceText("03"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatSpinner4 = onView(
allOf(withId(R.id.spnTipoVeiculo), isDisplayed()));
        appCompatSpinner4.perform(click());
        
        ViewInteraction appCompatCheckedTextView4 = onView(
allOf(withId(android.R.id.text1), withText("Tração Animal"), isDisplayed()));
        appCompatCheckedTextView4.perform(click());
        
        ViewInteraction appCompatButton6 = onView(
allOf(withId(R.id.btnSalvarObjetoOcorrencia), withText("Salvar"), isDisplayed()));
        appCompatButton6.perform(click());
        
        ViewInteraction appCompatButton7 = onView(
allOf(withId(R.id.btnVoltar), withText("Voltar"), isDisplayed()));
        appCompatButton7.perform(click());
        
        ViewInteraction floatingActionButton11 = onView(
allOf(withId(R.id.fabFoto), isDisplayed()));
        floatingActionButton11.perform(click());
        
        }

    }
