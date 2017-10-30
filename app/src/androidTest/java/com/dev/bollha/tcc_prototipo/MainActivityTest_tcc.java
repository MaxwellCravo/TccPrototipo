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
public class MainActivityTest_tcc {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void mainActivityTest_tcc() {
        ViewInteraction appCompatButton = onView(
allOf(withId(R.id.btnControlOcorrencia), withText("Nova Ocorrência"), isDisplayed()));
        appCompatButton.perform(click());
        
        ViewInteraction appCompatButton2 = onView(
allOf(withId(R.id.btnAtor), withText("Ator"), isDisplayed()));
        appCompatButton2.perform(click());
        
        ViewInteraction appCompatButton3 = onView(
allOf(withId(R.id.btnControlAtor), withText("Novo"), isDisplayed()));
        appCompatButton3.perform(click());
        
        ViewInteraction appCompatEditText = onView(
allOf(withId(R.id.edtNome), isDisplayed()));
        appCompatEditText.perform(replaceText("Maxwell Cravo"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText2 = onView(
allOf(withId(R.id.edtDocumento), isDisplayed()));
        appCompatEditText2.perform(replaceText("1267721677"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatEditText3 = onView(
allOf(withId(R.id.edtIdade), isDisplayed()));
        appCompatEditText3.perform(replaceText("42"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatButton4 = onView(
allOf(withId(R.id.btnSalvarAtor), withText("Salvar"), isDisplayed()));
        appCompatButton4.perform(click());
        
        ViewInteraction appCompatButton5 = onView(
allOf(withId(R.id.btnVoltar), withText("Voltar"), isDisplayed()));
        appCompatButton5.perform(click());
        
        ViewInteraction appCompatButton6 = onView(
allOf(withId(R.id.btnObjeto), withText("Objeto"), isDisplayed()));
        appCompatButton6.perform(click());
        
        ViewInteraction appCompatButton7 = onView(
allOf(withId(R.id.btnNovoObjeto), withText("Novo"), isDisplayed()));
        appCompatButton7.perform(click());
        
        ViewInteraction appCompatEditText4 = onView(
allOf(withId(R.id.edtMarca), isDisplayed()));
        appCompatEditText4.perform(replaceText("Renault"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText5 = onView(
allOf(withId(R.id.edtModelo), isDisplayed()));
        appCompatEditText5.perform(replaceText("Sandero Stepway"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText6 = onView(
allOf(withId(R.id.edtPlaca), isDisplayed()));
        appCompatEditText6.perform(replaceText("ODK-4795"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText7 = onView(
allOf(withId(R.id.edtAno), isDisplayed()));
        appCompatEditText7.perform(replaceText("2012"), closeSoftKeyboard());
        
        ViewInteraction appCompatEditText8 = onView(
allOf(withId(R.id.edtRenavam), isDisplayed()));
        appCompatEditText8.perform(replaceText("1234567"), closeSoftKeyboard());
        
        pressBack();
        
        ViewInteraction appCompatButton8 = onView(
allOf(withId(R.id.btnSalvarObjetoOcorrencia), withText("Salvar"), isDisplayed()));
        appCompatButton8.perform(click());
        
        }

    }
