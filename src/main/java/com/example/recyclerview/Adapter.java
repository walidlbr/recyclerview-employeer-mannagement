    package com.example.recyclerview;
    import android.annotation.SuppressLint;
    import android.content.Context;
    import android.graphics.Bitmap;
    import android.view.LayoutInflater;
    import android.view.View;
    import android.view.ViewGroup;
    import android.widget.AdapterView;
    import android.widget.AdapterView.OnItemClickListener;
    import android.widget.EditText;
    import android.widget.ImageView;
    import android.widget.TextView;

    import androidx.annotation.NonNull;
    import androidx.cardview.widget.CardView;
    import androidx.recyclerview.widget.RecyclerView;

    import java.util.List;

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>{

        private Context context;
        private List<ModelClass> userList;
        ItemClickListener itemClickListener;

        public interface ItemClickListener {
            void onItemClick(int position);
            void onDeleteClick(int position);
            void onModifyClick(int position);
        }

        public Adapter(Context context,List<ModelClass> userList,ItemClickListener itemClickListener) {
            this.userList=userList;
            this.itemClickListener = itemClickListener;
            this.context=context;
            this.userList=userList;

        }



        @NonNull
        @Override
        public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_design,parent,false);
            return new ViewHolder(view);


        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {

            Bitmap resource = userList.get(position).getImage();
            String name=userList.get(position).getTextview1().toString();
            String msg=userList.get(position).getTextview2().toString();

            String prenom1=userList.get(position).getPrenom().toString();
            String date=userList.get(position).getDate().toString();
            String numéro1=userList.get(position).getNumber().toString();

            holder.setData(resource,name,msg,prenom1,date,numéro1);


        }

        @Override
        public int getItemCount() {
            return userList.size();
        }





        public class ViewHolder extends RecyclerView.ViewHolder {
            private ImageView image;
            private TextView textView2;
            private TextView prenom;
            private TextView numéro;
            private TextView date;
            private CardView cardView;
            public ImageView bouttonmodifier;
            ImageView bouttonsupprimer;



            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                image=itemView.findViewById(R.id.imageview);
                textView2=itemView.findViewById(R.id.textview2);
                prenom=itemView.findViewById(R.id.textView60);
                numéro=itemView.findViewById(R.id.Divider);
                date=itemView.findViewById(R.id.textView20);

                itemView.setOnClickListener(v->itemClickListener.onItemClick(getAdapterPosition()));
                cardView=itemView.findViewById(R.id.imageview1);
                bouttonmodifier = itemView.findViewById(R.id.button3);
                bouttonsupprimer = itemView.findViewById(R.id.button4);
                bouttonsupprimer.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int positionx = getAdapterPosition();
                        if(positionx != RecyclerView.NO_POSITION) {
                             itemClickListener.onDeleteClick(positionx);
                        }
                    }
                });
                bouttonmodifier.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        int positionx = getAdapterPosition();
                        if(positionx != RecyclerView.NO_POSITION) {
                            itemClickListener.onModifyClick(positionx);
                        }
                    }
                });
            }

            public void setData(Bitmap resource, String nom, String msg , String prenom1,String date1,String numéro1) {
                image.setImageBitmap(resource);
                textView2.setText(msg);
                prenom.setText(prenom1);
                date.setText(date1);
                numéro.setText(numéro1);

            }
    }}

