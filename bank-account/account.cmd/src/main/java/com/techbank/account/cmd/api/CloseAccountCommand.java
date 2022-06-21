package com.techbank.account.cmd.api;

import com.techbank.cqrs.core.commands.BaseCommand;
import lombok.Data;


public class CloseAccountCommand extends BaseCommand {
    CloseAccountCommand(String id) {
        super(id);
    }
}
