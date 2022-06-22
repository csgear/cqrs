package com.techbank.account.cmd.api.commands;

import com.techbank.cqrs.core.commands.BaseCommand;
import lombok.Data;

/**
 * @author csgear
 */
@Data
public class WithdrawFundsCommand extends BaseCommand {
    private double amount;
}
