/*
 * This code is generated by blanco Framework.
 */
package my.db.exception;

import java.sql.SQLException;

/**
 * データベースタイムアウトに関する例外クラス <br>
 * このクラスはblancoDbが生成したソースコードで利用されます <br>
 * ※このクラスは、ソースコード自動生成後のファイルとして利用されます。
 * @since 2006.02.28
 * @author blanco Framework
 */
public class TimeoutException extends SQLException {
    /**
     * このクラスを表現するSQLStateコード。
     */
    protected static final String SQLSTATE_TIMEOUT = "HYT00";

    /**
     * データベースのタイムアウトが発生したことを示す例外オブジェクト のインスタンスを作成します。
     *
     * @deprecated このコンストラクタはなるべく利用せずに、もとの例外のSQLStateやvenderCodeを利用可能な別のコンストラクタを利用してください。
     */
    public TimeoutException() {
        super("Timeout exception has occured.", SQLSTATE_TIMEOUT);
    }

    /**
     * データベースのタイムアウトが発生したことを示す例外オブジェクト のインスタンスを作成します。
     *
     * @deprecated このコンストラクタはなるべく利用せずに、もとの例外のSQLStateやvenderCodeを利用可能な別のコンストラクタを利用してください。
     *
     * @param reason 例外の説明
     */
    public TimeoutException(final String reason) {
        super(reason, SQLSTATE_TIMEOUT);
    }

    /**
     * データベースのタイムアウトが発生したことを示す例外オブジェクト のインスタンスを作成します。
     *
     * @deprecated このコンストラクタはなるべく利用せずに、もとの例外のSQLStateやvenderCodeを利用可能な別のコンストラクタを利用してください。
     *
     * @param reason 例外の説明
     * @param SQLState 例外を識別する XOPENコードまたは SQL 99のコード
     */
    public TimeoutException(final String reason, final String SQLState) {
        super(reason, SQLState);
    }

    /**
     * データベースのタイムアウトが発生したことを示す例外オブジェクト のインスタンスを作成します。
     *
     * @param reason 例外の説明
     * @param SQLState 例外を識別する XOPENコードまたは SQL 99のコード
     * @param vendorCode データベースベンダーが定める固有の例外コード
     */
    public TimeoutException(final String reason, final String SQLState, final int vendorCode) {
        super(reason, SQLState, vendorCode);
    }
}