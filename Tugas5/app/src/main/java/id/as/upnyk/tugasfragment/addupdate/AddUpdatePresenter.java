package id.as.upnyk.tugasfragment.addupdate;

import android.os.AsyncTask;

import id.as.upnyk.tugasfragment.db.AppDatabase;
import id.as.upnyk.tugasfragment.db.Order;

public class AddUpdatePresenter {
    AddUpdateContact.AddUpdateView addUpdateView;

    public AddUpdatePresenter(AddUpdateContact.AddUpdateView addUpdateView) {
        this.addUpdateView = addUpdateView;
    }

    public void insertOrder(AppDatabase appDatabase, String name, int quantity){
        Order order = new Order();
        order.setName(name);
        order.setQuantity(quantity);
        new InsertOrderAsync(appDatabase, order).execute();
    }

    public class InsertOrderAsync extends AsyncTask<Void, Void, Long>{
        AppDatabase appDatabase;
        Order order;

        public InsertOrderAsync(AppDatabase appDatabase, Order order) {
            this.appDatabase = appDatabase;
            this.order = order;
        }

        @Override
        protected Long doInBackground(Void... voids) {
            return appDatabase.orderDAO().insertData(order);
        }

        @Override
        protected void onPostExecute(Long aLong) {
            super.onPostExecute(aLong);
            addUpdateView.onSuccessAdd();
        }
    }

    public void editOrder(AppDatabase appDatabase, Order order){
        new EditOrderAsyncTask(appDatabase, order).execute();
    }

    private class EditOrderAsyncTask extends AsyncTask<Void, Void, Integer>{
        AppDatabase appDatabase;
        Order order;

        public EditOrderAsyncTask(AppDatabase appDatabase, Order order) {
            this.appDatabase = appDatabase;
            this.order = order;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return appDatabase.orderDAO().updateData(order);
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            addUpdateView.onSuccessUpdate();
        }
    }

    public void deleteOrder(AppDatabase appDatabase, Order order){
        new DeleteOrderAsyncTask(appDatabase, order).execute();
    }

    private class DeleteOrderAsyncTask extends AsyncTask<Void, Void, Void>{
        AppDatabase appDatabase;
        Order order;

        public DeleteOrderAsyncTask(AppDatabase appDatabase, Order order) {
            this.appDatabase = appDatabase;
            this.order = order;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            appDatabase.orderDAO().deleteData(order);
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            addUpdateView.onSuccessDelete();
        }
    }
}
