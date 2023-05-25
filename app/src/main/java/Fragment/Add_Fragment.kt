package Fragment

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import androidx.fragment.app.Fragment
import com.alpesh1.material_textview.databinding.FragmentAddBinding
import java.sql.Date
import java.text.SimpleDateFormat


class Add_Fragment : Fragment() {

    lateinit var binding: FragmentAddBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentAddBinding.inflate(layoutInflater)

        initView()

        return binding.root
    }

    private fun initView() {
        binding.setDate.setOnClickListener {

            var date = Date()
            var Format = SimpleDateFormat("DD/MM/YYYY")
            var curreDate = Format.format(date)

            var dates = curreDate.split("/")
            binding.setDate.text = curreDate

            var dialog =
                DatePickerDialog(requireContext(), object : DatePickerDialog.OnDateSetListener {
                    override fun onDateSet(
                        p0: DatePicker?,
                        year: Int,
                        month: Int,
                        dayofMonth: Int
                    ) {


                        var selectDate = "$dayofMonth/${month + 1}/$year"
                        binding.setDate.text = selectDate
                    }

                }, dates[2].toInt(), dates[1].toInt() - 1, dates[0].toInt())
            dialog.show()
        }
    }

    private fun Date(): java.util.Date {
        TODO("Not yet implemented")
    }


}