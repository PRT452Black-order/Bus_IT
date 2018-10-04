package com.example.cdu_nb.bus_it;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.paypal.android.sdk.payments.PayPalConfiguration;
import com.paypal.android.sdk.payments.PayPalPayment;
import com.paypal.android.sdk.payments.PayPalService;
import com.paypal.android.sdk.payments.PaymentActivity;
import com.paypal.android.sdk.payments.PaymentConfirmation;

import java.math.BigDecimal;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    //PayPal setup
    TextView m_response;
    PayPalConfiguration m_configuration;
    String m_paypalClientId = "ATcecTRpX3n35-ldymh8EW1-Q8jO1OpgVc6VMImnXl_tTFzs88LB0R3Wi9eB7ioKXVIu3kBewxODx6GG";
    Intent m_service;
    int m_paypalRequestCode = 999;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setting search bus page as default page after login
        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.main, new SearchBusFrag());
        tx.commit();
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        m_response = (TextView) findViewById(R.id.response);
        m_configuration = new PayPalConfiguration().environment(PayPalConfiguration.ENVIRONMENT_SANDBOX).clientId(m_paypalClientId);
        m_service = new Intent(this, PayPalService.class);
        m_service.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        startService(m_service);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_searchbus) {
            // Handle the search bus action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new SearchBusFrag()).commit();

        } else if (id == R.id.nav_topup) {
            // Handle the topup action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new TopUpFrag()).commit();

        }

        else if (id == R.id.nav_tapgo) {
            // Handle the tap and go action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new TapGoFrag()).commit();

        }

        else if (id == R.id.nav_history) {
            // Handle the history action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new HistoryFrag()).commit();

        }

        else if (id == R.id.nav_help) {
            // Handle the help action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new HelpFrag()).commit();

        }

        else if (id == R.id.nav_account) {
            // Handle the account action
            getSupportFragmentManager().beginTransaction().replace(R.id.main,
                    new AccountFrag()).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    void paySingle(View view) {
        PayPalPayment payment = new PayPalPayment(new BigDecimal(3), "AUD", "Single Trip", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    void payDaily(View view) {
        PayPalPayment payment = new PayPalPayment(new BigDecimal(7), "AUD", "Full Day Trip", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    void payWeekly(View view) {
        PayPalPayment payment = new PayPalPayment(new BigDecimal(20), "AUD", "Full Week Trip", PayPalPayment.PAYMENT_INTENT_SALE);

        Intent intent = new Intent(this, PaymentActivity.class);
        intent.putExtra(PayPalService.EXTRA_PAYPAL_CONFIGURATION, m_configuration);
        intent.putExtra(PaymentActivity.EXTRA_PAYMENT, payment);
        startActivityForResult(intent, m_paypalRequestCode);
    }

    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == m_paypalRequestCode) {
            if(resultCode == Activity.RESULT_OK) {
                PaymentConfirmation confirmation = data.getParcelableExtra(PaymentActivity.EXTRA_RESULT_CONFIRMATION);

                if(confirmation != null) {
                    String state = confirmation.getProofOfPayment().getState();

                    if(state.equals("approved")) {
                        getSupportFragmentManager().beginTransaction().replace(R.id.main,
                                new TapGoFrag()).commit();
                    } else {
                        m_response.setText("error in the payment");
                    }
                } else {
                    m_response.setText("confirmation is null");
                }
            }
        }
    }
}
