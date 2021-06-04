package id.as.upnyk.tugasfragment.addupdate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import id.as.upnyk.tugasfragment.R;
import id.as.upnyk.tugasfragment.db.AppDatabase;
import id.as.upnyk.tugasfragment.db.Order;

public class AddUpdateOrderActivity extends AppCompatActivity implements View.OnClickListener, AddUpdateContact.AddUpdateView{

    private EditText etName, etQuantity;
    private TextView tvFormTitle;
    private Button btnSubmit, btnDelete;
    private AddUpdatePresenter addUpdatePresenter;
    private AppDatabase appDatabase;

    private Order order;
    private boolean isEdit = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_update_order);

        etName = findViewById(R.id.et_name);
        etQuantity = findViewById(R.id.et_quantity);
        btnSubmit = findViewById(R.id.btn_submit);
        btnDelete = findViewById(R.id.btn_delete);
        tvFormTitle = findViewById(R.id.tv_form_title);
        addUpdatePresenter = new AddUpdatePresenter(this);
        appDatabase = AppDatabase.getInstance(this);

        btnSubmit.setOnClickListener(this);
        btnDelete.setOnClickListener(this);

        order = getIntent().getParcelableExtra("EXTRA_ORDER");
        if (order != null){
            isEdit = true;
            tvFormTitle.setText("Edit Order");
            etName.setText(order.getName());
            etQuantity.setText(String.valueOf(order.getQuantity()));
            btnDelete.setText("DELETE");
        }

    }

    @Override
    public void onClick(View v) {
        if (v == btnSubmit){
            if (orderDataIsComplete()){
                if (isEdit){
                    order.setName(etName.getText().toString().trim());
                    order.setQuantity(Integer.parseInt(etQuantity.getText().toString().trim()));
                    addUpdatePresenter.editOrder(appDatabase, order);
                } else {
                    addUpdatePresenter.insertOrder(appDatabase, etName.getText().toString().trim(), Integer.parseInt(etQuantity.getText().toString()));
                }
            } else {
                Toast.makeText(this, "Isi semua data untuk lanjut", Toast.LENGTH_SHORT).show();
            }
        } else if (v == btnDelete){
            if(isEdit){
                addUpdatePresenter.deleteOrder(appDatabase, order);
            } else {
                etName.setText("");
                etQuantity.setText("");
            }
        }
    }

    @Override
    public void onSuccessAdd() {
        Toast.makeText(this, "Success add new order", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSuccessUpdate() {
        Toast.makeText(this, "Success update order", Toast.LENGTH_SHORT).show();
        finish();
    }

    @Override
    public void onSuccessDelete() {
        Toast.makeText(this, "Success delete order", Toast.LENGTH_SHORT).show();
        finish();
    }

    public boolean orderDataIsComplete(){
        return !etName.getText().toString().isEmpty()
                && !etQuantity.getText().toString().isEmpty()
                && Integer.parseInt(etQuantity.getText().toString()) != 0;
    }
}