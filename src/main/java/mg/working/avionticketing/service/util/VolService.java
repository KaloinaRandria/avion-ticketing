package mg.working.avionticketing.service.util;

import mg.working.avionticketing.entity.avion.Avion;
import mg.working.avionticketing.entity.util.Ville;
import mg.working.avionticketing.entity.util.Vol;
import mg.working.avionticketing.repository.util.VolRepository;
import mg.working.avionticketing.service.avion.AvionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class VolService {
    @Autowired
    VolRepository volRepository;
    @Autowired
    AvionService avionService;
    @Autowired
    VilleService villeService;
    @Autowired
    DataSource dataSource;

    public String sql(String idAvion, String idVilleDepart, String idVilleArrivee, String dateDepart, String dateArrivee, String prixBase) {
        StringBuilder query = new StringBuilder("SELECT * FROM vol WHERE 1=1");

        if (!idAvion.isEmpty()) query.append(" AND id_avion = ?");
        if (!idVilleDepart.isEmpty()) query.append(" AND ville_depart = ?");
        if (!idVilleArrivee.isEmpty()) query.append(" AND ville_arrivee = ?");
        if (!dateDepart.isEmpty()) query.append(" AND date_depart = ?");
        if (!dateArrivee.isEmpty()) query.append(" AND date_arrivee = ?");
        if (!prixBase.isEmpty()) query.append(" AND prix_base = ?");

        return query.toString();
    }


    public void insertVol(Vol vol) {
        volRepository.save(vol);
    }

    public List<Vol> getAllVol() {
        return volRepository.findAll();
    }

    public Vol getVolById(int id) {
        return volRepository.findById(id).orElse(null);
    }

    public List<Vol> getListVolBFilter(Connection connection, String idAvion, String idVilleDepart, String idVilleArrivee, String dateDepart, String dateArrivee, String prixBase) {
        List<Vol> vols = new ArrayList<>();
        boolean check = false;

        try {
            if (connection == null) {
                connection = dataSource.getConnection();
                check = true;
            }

            String query = this.sql(idAvion, idVilleDepart, idVilleArrivee, dateDepart, dateArrivee, prixBase);
            System.out.println("Query: " + query);

            PreparedStatement preparedStatement = connection.prepareStatement(query);
            int index = 1;

            if (!idAvion.isEmpty()) preparedStatement.setInt(index++, Integer.parseInt(idAvion));
            if (!idVilleDepart.isEmpty()) preparedStatement.setInt(index++, Integer.parseInt(idVilleDepart));
            if (!idVilleArrivee.isEmpty()) preparedStatement.setInt(index++, Integer.parseInt(idVilleArrivee));
            if (!dateDepart.isEmpty()) preparedStatement.setTimestamp(index++, Timestamp.valueOf(dateDepart));
            if (!dateArrivee.isEmpty()) preparedStatement.setTimestamp(index++, Timestamp.valueOf(dateArrivee));
            if (!prixBase.isEmpty()) preparedStatement.setBigDecimal(index++, new BigDecimal(prixBase));

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Vol vol = new Vol();
                vol.setId(resultSet.getInt("id_vol"));

                Avion avion = avionService.getAvionById(resultSet.getInt("id_avion"));
                vol.setAvion(avion);

                Ville villeDepart = villeService.getVilleById(resultSet.getInt("ville_depart"));
                vol.setVilleDepart(villeDepart);

                Ville villeArrivee = villeService.getVilleById(resultSet.getInt("ville_arrivee"));
                vol.setVilleArrivee(villeArrivee);


                vol.setDateDepart(String.valueOf(resultSet.getTimestamp("date_depart").toLocalDateTime()));
                vol.setDateArrivee(String.valueOf(resultSet.getTimestamp("date_arrivee").toLocalDateTime()));
                vol.setPrixBase(String.valueOf(resultSet.getBigDecimal("prix_base")));

                vols.add(vol);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            if (check) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        return vols;
    }

}
