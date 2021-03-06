/*
 * This code is generated by blanco Framework.
 */
package my.db.query;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import blanco.db.runtime.BlancoDbQuery;
import blanco.fw.BlancoGeneratedBy;

import my.db.exception.DeadlockException;
import my.db.exception.TimeoutException;
import my.db.row.SimpleTestBlancodbSelectAllRow;
import my.db.util.BlancoDbUtil;

/**
 * [SimpleTestBlancodbSelectAll]  (QueryIterator)
 *
 * 検索型SQL文をラッピングして各種アクセサを提供します。<br>
 * スクロール属性: insensitive<br>
 */
@BlancoGeneratedBy(name = "blancoDb")
public class SimpleTestBlancodbSelectAllIterator implements BlancoDbQuery {
    /**
     * このクラスが内部的に利用するデータベース接続オブジェクト。
     *
     * データベース接続オブジェクトはコンストラクタの引数として外部から与えられます。<br>
     * トランザクションのコミットやロールバックは、このクラスの内部では実行しません。
     */
    protected Connection fConnection;

    /**
     * このクラスが内部的に利用するステートメントオブジェクト。
     *
     * このオブジェクトはデータベース接続オブジェクトから生成されて内部的に利用されます。<br>
     * closeメソッドの呼び出し時に、このオブジェクトのcloseを実行します。
     */
    protected PreparedStatement fStatement;

    /**
     * このクラスが内部的に利用する結果セットオブジェクト。
     *
     * このオブジェクトはデータベースステートメントオブジェクトから生成されて内部的に利用されます。<br>
     * closeメソッドの呼び出し時に、このオブジェクトのcloseを実行します。
     */
    protected ResultSet fResultSet;

    /**
     * SimpleTestBlancodbSelectAllIteratorクラスのコンストラクタ。
     *
     * データベースコネクションオブジェクトを引数としてクエリクラスを作成します。<br>
     * このクラスの利用後は、必ず close()メソッドを呼び出す必要があります。<br>
     *
     * @param conn データベース接続
     */
    public SimpleTestBlancodbSelectAllIterator(final Connection conn) {
        fConnection = conn;
    }

    /**
     * SimpleTestBlancodbSelectAllIteratorクラスのコンストラクタ。
     *
     * データベースコネクションオブジェクトを与えずにクエリクラスを作成します。<br>
     */
    @Deprecated
    public SimpleTestBlancodbSelectAllIterator() {
    }

    /**
     * SimpleTestBlancodbSelectAllIteratorクラスにデータベース接続を設定。
     *
     * @param conn データベース接続
     */
    @Deprecated
    public void setConnection(final Connection conn) {
        fConnection = conn;
    }

    /**
     * SQL定義書で与えられたSQL文を取得します。
     *
     * SQL入力パラメータとして #キーワードによる指定がある場合には、該当箇所を ? に置き換えた後の SQL文が取得できます。
     *
     * @return JDBCドライバに与えて実行可能な状態のSQL文。
     */
    public String getQuery() {
        return "\n        SELECT COL_ID, COL_TEXT, COL_NUMERIC\n  FROM TEST_BLANCODB\n ORDER BY COL_ID\n      ";
    }

    /**
     * SQL定義書から与えられたSQL文をもちいてプリコンパイルを実施します。
     *
     * 内部的にConnection.prepareStatementを呼び出します。<br>
     *
     * @throws SQLException SQL例外が発生した場合。
     */
    public void prepareStatement() throws SQLException {
        close();
        prepareStatement(getQuery());
    }

    /**
     * 与えられたSQL文をもちいてプリコンパイルを実施(動的SQL)します。
     *
     * このメソッドは、動的に内容が変化するような SQL を実行する必要がある場合にのみ利用します。<br>
     * 動的 SQL を利用する必要がある場合には、SQL 定義書で「動的SQL」を「使用する」に変更してください。変更後は外部から利用可能になります。<br>
     * 内部的に JDBC ドライバの Connection.prepareStatement を呼び出します。<br>
     * スクロール属性: insensitive
     *
     * @param query プリコンパイルを実施させたいSQL文。動的SQLの場合には、この引数には加工された後の実行可能なSQL文を与えます。
     * @throws SQLException SQL例外が発生した場合。
     */
    protected void prepareStatement(final String query) throws SQLException {
        close();
        fStatement = fConnection.prepareStatement(query, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    /**
     * 検索型クエリを実行します。<br>
     *
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public void executeQuery() throws DeadlockException, TimeoutException, SQLException {
        if (fStatement == null) {
            // PreparedStatementが未取得の状態なので、PreparedStatement.executeQuery()実行に先立ちprepareStatement()メソッドを呼び出して取得します。
            prepareStatement();
        }
        if (fResultSet != null) {
            // 前回の結果セット(ResultSet)が残っているので、これを一旦開放します。
            fResultSet.close();
            fResultSet = null;
        }

        try {
            fResultSet = fStatement.executeQuery();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを現在の位置から1行次へ移動します。
     *
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean next() throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.next();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを現在の位置から1行前へ移動します。
     *
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean previous() throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.previous();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを結果セットの先頭行へ移動します。
     *
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean first() throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.first();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを結果セットの最終行へ移動します。
     *
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean last() throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.last();
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを結果セットの指定された行へ移動します。
     *
     * absolute(1)はfirst()を呼び出すのと同じです。<br>
     * absolute(-1)はlast()を呼び出すのと同じです。<br>
     *
     * @param rows カーソルの移動先の行番号を指定します。正の番号の場合には結果セットの先頭からカウントします。負の番号の場合は結果セットの終端からカウントします。
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean absolute(final int rows) throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.absolute(rows);
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * カーソルを結果セットの相対行数だけ移動します。
     * relative(1)はnext()を呼び出すのと同じです。<br>
     * relative(-1)はprevious()を呼び出すのと同じです。<br>
     *
     * @param rows 現在の行から移動する相対行数を指定します。正の数ではカーソルを順方向に移動し、負の数ではカーソルを逆方向に移動します。
     * @return 新しい現在の行が有効な場合はtrue、それ以上の行がない場合はfalse。
     * @throws DeadlockException データベースデッドロックが発生した場合。
     * @throws TimeoutException データベースタイムアウトが発生した場合。
     * @throws SQLException SQL例外が発生した場合。
     */
    public boolean relative(final int rows) throws DeadlockException, TimeoutException, SQLException {
        if (fResultSet == null) {
            executeQuery();
        }

        try {
            return fResultSet.relative(rows);
        } catch (SQLException ex) {
            throw BlancoDbUtil.convertToBlancoException(ex);
        }
    }

    /**
     * 現在の行のデータをオブジェクトとして取得します。
     *
     * このメソッドを呼び出す前に、next()などのカーソルを操作するメソッドを呼び出す必要があります。
     *
     * @return 行オブジェクト。
     * @throws SQLException SQL例外が発生した場合。
     */
    public SimpleTestBlancodbSelectAllRow getRow() throws SQLException {
        SimpleTestBlancodbSelectAllRow result = new SimpleTestBlancodbSelectAllRow();
        result.setColId(fResultSet.getInt(1));
        result.setColText(fResultSet.getString(2));
        result.setColNumeric(new Double(fResultSet.getDouble(3)));
        if (fResultSet.wasNull()) {
            result.setColNumeric(null);
        }

        return result;
    }

    /**
     * ステートメント (java.sql.PreparedStatement) を取得します。
     * @deprecated 基本的にStatementは外部から直接利用する必要はありません。
     *
     * @return 内部的に利用されている java.sql.PreparedStatementオブジェクト
     */
    public PreparedStatement getStatement() {
        return fStatement;
    }

    /**
     * 内部的に保持されているResultSetオブジェクトを取得します。
     *
     * @deprecated 基本的にResultSetは外部から直接利用する必要はありません。
     *
     * @return ResultSetオブジェクト。
     */
    public ResultSet getResultSet() {
        return fResultSet;
    }

    /**
     * 検索結果をリストの形式で取得します。
     *
     * リストには SimpleTestBlancodbSelectAllクラスが格納されます。<br>
     * 検索結果の件数があらかじめわかっていて、且つ件数が少ない場合に利用することができます。<br>
     * 検索結果の件数が多い場合には、このメソッドは利用せず、代わりに next()メソッドを利用することをお勧めします。<br>
     *
     * @param absoluteStartPoint 読み出しを開始する行。最初の行から読み出したい場合には 1 を指定します。
     * @param size 読み出しを行う行数。
     * @return SimpleTestBlancodbSelectAllクラスのList。検索結果が0件の場合には空のリストが戻ります。
     * @throws SQLException SQL例外が発生した場合。
     */
    public List<SimpleTestBlancodbSelectAllRow> getList(final int absoluteStartPoint, final int size) throws SQLException {
        List<SimpleTestBlancodbSelectAllRow> result = new ArrayList<SimpleTestBlancodbSelectAllRow>(8192);
        if (absolute(absoluteStartPoint) == false) {
            return result;
        }
        for (int count = 1; count <= size; count++) {
            if (count != 1) {
                if (next() == false) {
                    break;
                }
            }
            result.add(getRow());
        }
        return result;
    }

    /**
     * このクラスのクローズ処理をおこないます。
     *
     * 内部的に生成していたJDBCリソースのオブジェクトに対して close()メソッドの呼び出しをおこないます。<br>
     * クラスの利用が終わったら、必ずこのメソッドを呼び出すようにします。
     *
     * @throws SQLException SQL例外が発生した場合。
     */
    public void close() throws SQLException {
        try {
            if (fResultSet != null) {
                fResultSet.close();
                fResultSet = null;
            }
        } finally {
            if (fStatement != null) {
                fStatement.close();
                fStatement = null;
            }
        }
    }

    /**
     * finalizeメソッド。
     *
     * このクラスが内部的に生成したオブジェクトのなかで、close()呼び出し忘れバグが存在するかどうかチェックします。<br>
     *
     * @throws Throwable finalize処理の中で発生した例外。
     */
    protected void finalize() throws Throwable {
        super.finalize();
        if (fStatement != null) {
            final String message = "SimpleTestBlancodbSelectAllIterator : close()メソッドによるリソースの開放が行われていません。";
            System.out.println(message);
        }
    }
}
