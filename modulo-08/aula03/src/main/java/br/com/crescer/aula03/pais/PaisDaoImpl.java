package br.com.crescer.aula03.pais;

import br.com.crescer.aula03.ConnectionUtils;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author carloshenrique
 */
public class PaisDaoImpl implements PaisDao {

    private static final String INSERT_PESSOA = "INSERT INTO PESSOA (ID, NOME) VALUES (?,?)";
    private static final String UPDATE_PESSOA = "UPDATE PESSOA SET NOME = ? WHERE ID = ?";
    private static final String DELETE_PESSOA = "DELETE FROM PESSOA WHERE ID = ?";
    private static final String LOAD_PESSOA = "SELECT * FROM PESSOA WHERE ID = ?";

    @Override
    public void insert(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(INSERT_PESSOA)) {

            preparedStatement.setLong(1, pais.getId());
            preparedStatement.setString(2, pais.getNome());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void update(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(UPDATE_PESSOA)) {
            preparedStatement.setString(1, pais.getNome());
            preparedStatement.setLong(2, pais.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public void delete(Pais pais) {
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(DELETE_PESSOA)) {
            preparedStatement.setLong(1, pais.getId());
            preparedStatement.executeUpdate();
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
    }

    @Override
    public Pais loadBy(Long id) {
        final Pais pessoa = new Pais();
        try (final PreparedStatement preparedStatement
                = ConnectionUtils.getConnection().prepareStatement(LOAD_PESSOA)) {
            preparedStatement.setLong(1, id);
            try (final ResultSet resultSet = preparedStatement.executeQuery()) {

                while (resultSet.next()) {
                    pessoa.setId(resultSet.getLong("ID"));
                    pessoa.setNome(resultSet.getString("NOME"));
                }
            } catch (final SQLException e) {
                System.err.format("SQLException: %s", e);
            }
        } catch (final SQLException e) {
            System.err.format("SQLException: %s", e);
        }
        return pessoa;
    }

}
