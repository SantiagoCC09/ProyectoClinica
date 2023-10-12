package co.edu.uniquindio.clinica.servicios.implementacion;

import co.edu.uniquindio.clinica.dto.EmailDTO;
import co.edu.uniquindio.clinica.servicios.interfaces.EmailServicio;
import jakarta.mail.internet.MimeMessage;
import lombok.AllArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailServicioImpl implements EmailServicio {

    private final JavaMailSender javaMailSender;


    @Override
    public void enviarEmail(EmailDTO emailDTO) {

        MimeMessage mensaje = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mensaje);
        try{
            helper.setSubject(emailDTO.asunto());
            helper.setText(emailDTO.cuerpo(), true);
            helper.setTo(emailDTO.destinatario());
            helper.setFrom("juan-felipe-00@hotmail.com");//"no_reply@dominio.com");
            javaMailSender.send(mensaje);
        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
